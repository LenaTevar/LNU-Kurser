import lnu.resources.*;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

// Look at this to find out how to create an api test.
// Info on how to test with dropwizard: http://www.dropwizard.io/0.8.0/docs/manual/testing.html


public class PingResourceTest {

	@ClassRule
	public static final ResourceTestRule resources = ResourceTestRule.builder()
			.addResource(new PingResource())
			.build();

	@Test
	public void testGetPing() {
		assertThat(resources.client().target("/ping").request().get(String.class))
				.isEqualTo("{\"answer\": \"pong\"}");
	}
}

/*
INFO FOUND ABOUT JUNIT
MOCKITO -> http://site.mockito.org/
				-> http://www.vogella.com/tutorials/Mockito/article.html

EXCEPTIONS AND junit
public class FooTest {
  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void doStuffThrowsIndexOutOfBoundsException() {
    Foo foo = new Foo();

    exception.expect(IndexOutOfBoundsException.class);
    foo.doStuff();
  }
}

lambda
http://blog.codeleak.pl/2014/07/junit-testing-exception-with-java-8-and-lambda-expressions.html


@Test
	 public void verifiesCauseType() {
			 // lambda expression
			 assertThrown(() -> new DummyService().someOtherMethod(true))
							 // assertions
							 .isInstanceOf(RuntimeException.class)
							 .hasMessage("Runtime exception occurred")
							 .hasCauseInstanceOf(IllegalStateException.class);
	 }



*/
