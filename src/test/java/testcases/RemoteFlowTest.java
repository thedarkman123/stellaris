package testcases;

import org.testng.annotations.Test;

public class RemoteFlowTest extends RemoteBaseTest {

	@Test
	public void test1() {
		rdw.openUrl("https://btc-gain.com/");
	}
}
