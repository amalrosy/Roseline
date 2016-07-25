import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;
import org.junit.Test;
import play.mvc.Result;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.GET;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.routeAndCall;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("Your new application is ready.");
    }
	 @Test
    public void empTestRoute() {
        Result result = routeAndCall(fakeRequest(GET, "/"));
        assertThat(result).isNotNull();
    }
	@Test
    public void empTest1() {
        Result result = routeAndCall(fakeRequest(GET, "/employees"));
        assertThat(result).isNotNull();
    }
	@Test
    public void empTest2() {
        Result result = routeAndCall(fakeRequest(GET, "/employee/1"));
        assertThat(result).isNotNull();
    }
	@Test
    public void empTest3() {
        Result result = routeAndCall(fakeRequest(GET, "/delemployee/2"));
        assertThat(result).isNotNull();
    }
    @Test
    public void badRoute() {
        Result result = routeAndCall(fakeRequest(GET, "/bad"));
        assertThat(result).isNull();
    }


}
