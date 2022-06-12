# Java-reactive-practise
This repo consist of all the practise programs written for Java Reactive


## Notes
> - <p>Reactive Programming is Subset / Special case of event-driven / asynchronous programming in which you register a set of 
call backs or listeners to be execulted as an when data goes through the pipeline. It's a declarative data flow programming.</p>
<p> # Publisher / Subscriber Communication: </p>
><p> Step 1: Subscriber wants to connect</p>

> ```
public interface Publisher<T> {
	public void subscribe(Subscriber<? super T> s);
}
```
>> * <p> Subscriber wants to get data from the Publisher.</p>
>> * <p> Publisher Interface has subscribe() which accepts Subscriber instance as argument.</p> </br>

>> <p> Step 2: Publisher calls onSubscribe</p>

> ```
public interface Subscriber<T> {
	public void onSubscribe(Subscription s);
	public void onNext(T t);
	public void onError(Throwable t);
	public void onComplete();
}
```
>> * <p> When publisher accepts the request of Subscriber using onSubscribe() he pass Subscription object as argument.</p> </br>

>> <p> Step 3: Subscription</p>

> ```
public interface Subscription {
	public void request(long n);
	public void cancel();
}
```
>> * <p> The Publisher and Subscriber relation has been establish at this point through Subscription object.</p>
>> * <p> The Subscriber can make use of request() to receive the data or use cancel() if it doesn't want to receive anymore data.</p> </br>

>> <p> Step 4: Publisher pushes data via onNext</p>


>> * <p> When Subscriber request data from Publisher through Subscription object then, the Publisher use onNext() of the Subscriber to provide the data. For Example: If there a 5 items then it will call onNext() 5 times.</p> </br>

>> <p> Step 5: OnComplete</p>


>> * <p>Once all the items are pass or if there are no items to pass(empty) to Subscriber then Publisher can call onComplete().</p> </br>

>> <p> Step 6: onError</p>


>> * <p>If the publisher encounters any error while passing the data to Subscriber then it can use onError() to pass the error details to Subscriber.</p> </br>

> - <p> Mono will emit 0 or 1 item. Followed by an onComplete/ onError. </p>
> - <p> You can always build the reactive pipeline. But it will only get executed when the subscribe() is called. </p> 
> - <p> Anything things else other than the pipeline will get printed even if the subscribe() is not called. 
Please run the program Lec06SupplierRefactoring.java for better understanding.</p>
> - <p> Flux emit 0, 1 ... N item. Followed by an onComplete/ onError. </p> </br>

<table>
	<tr>
		<th colspan="2">
			Terminologies
		</th>
	</tr>
	<tr>
		<th>
			Publisher
		</th>
		<th>
			Subscriber
		</th>
	</tr>
	<tr>
		<td style="text-align:center">
			Source
		</td>
		<td style="text-align:center">
			Sink
		</td>
	</tr>
	<tr>
		<td style="text-align:center">
			Observable
		</td>
		<td style="text-align:center">
			Observer
		</td>
	</tr>
	<tr>
		<td style="text-align:center">
			Upstream
		</td>
		<td style="text-align:center">
			Producer
		</td>
	</tr>
	<tr>
		<td style="text-align:center">
			Downstream
		</td>
		<td style="text-align:center">
			Consumer
		</td>
	</tr>
</table>

