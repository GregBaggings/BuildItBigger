import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.util.Pair;

import com.udacity.gradle.builditbigger.AsyncJokeHandler;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.InstrumentationRegistry.getInstrumentation;


@RunWith(AndroidJUnit4.class)
public class AsyncJokeEndpointTest {

    private final Context context = getInstrumentation().getTargetContext();

    @Test
    public void testDoInBackground() throws Exception {
        AsyncJokeHandler asyncJokeHandler = new AsyncJokeHandler();
        asyncJokeHandler.execute(new Pair<>(context, "Test"));
        String joke = asyncJokeHandler.get(10, TimeUnit.SECONDS);
        Assert.assertTrue(joke.length() != 0);
    }

}