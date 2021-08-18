目标: 错误测试，针对系统应该返回的异常提示
## 1. 一个异常

```java
@Test(expectedExceptions = ReservationException.class)
public void shouldThrowIfPlaneIsFull() { 
 	plane plane = createPlane();
 	plane.bookAllSeats();
 	plane.bookPlane(createValidItinerary(), null); 
}
```

## 2. 多个异常
```java
 public class BookingTest {
	private Plane plane; 

	# 每次执行时都会初始化这个对象，保证下面的异常能够顺利触发
	@BeforeMethod
  	public void init() { 
 		plane = createPlane();
  	} 

 	@Test(expectedExceptions = PlaneFullException.class)
  	public void shouldThrowIfPlaneIsFull() { 
 		plane.bookAllSeats(); 
 		plane.bookPlane(createValidItinerary(), null);
  	}
   

	@Test(expectedExceptions = FlightCanceledException.class)
  	public void shouldThrowIfFlightIsCanceled() { 
 		cancelFlight(/* ... */); 
 		plane.bookPlane(createValidItinerary(), null);
  	} 
}
```

3. 测试异常返回的消息或对象

```java
@Test
public void shouldThrowIfPlaneIsFull() {
 
	Plane plane = createPlane();
  	plane.bookAllSeats();
  	try { 
 		plane.bookPlane(createValidItinerary(), null); 
 		fail("The reservation should have failed");
  	} 

 	catch(ReservationException ex) {
    	// success, do nothing: the test will pass 

	}
}

```