package guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class GuiceTest {

	class TestModule extends AbstractModule {
		public void configure() {
			bind(TransactionLog.class).to(ConsoleTransactionLog.class);
			bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);
		}
	}

	interface BillingService {
		boolean charge(int amount);
	}

	interface TransactionLog {

		void logTransaction(String msg);
	}

	static class ConsoleTransactionLog implements TransactionLog {
		public void logTransaction(String msg) {
			System.out.println("Logging to console" + msg);
		}
	}

	static class DBTransactionLog implements TransactionLog {
		public void logTransaction(String msg) {
			System.out.println("Logging to DB" + msg);
		}
	}

	interface CreditCardProcessor {

		boolean charge(int amount);
	}

	static class PaypalCreditCardProcessor implements CreditCardProcessor {
		PaypalCreditCardProcessor(String i){
			
		}
		
		public boolean charge(int amount) {
			System.out.println("charging amount " + amount + " from paypal");
			return true;
		}

	}

	static class StripeCardProcessor implements CreditCardProcessor {
		public boolean charge(int amount) {
			System.out.println("charging amount " + amount + " from google");
			return true;
		}

	}

	static class RealBillingService implements BillingService {
		TransactionLog log;
		CreditCardProcessor processor;

		@Inject
		RealBillingService(TransactionLog log, CreditCardProcessor processor) {
			this.log = log;
			this.processor = processor;
		}

		public boolean charge(int amount) {
			log.logTransaction("Charging " + amount);
			return processor.charge(amount);
		}
	}

	public void test() {

		Injector i = Guice.createInjector(new TestModule());

		RealBillingService s = i.getInstance(RealBillingService.class);

		s.charge(10);

	}

}
