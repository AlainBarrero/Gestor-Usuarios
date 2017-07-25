package com.alain.monetizacion.service.paypal;

import java.util.HashMap;

import com.alain.monetizacion.model.SubsConfiguration;

public interface ExpressCheckoutService {
	
	HashMap<String, String> SetExpressCheckoutRecurringPayments(String returnURL, String cancelURL, SubsConfiguration sconfig) throws Exception;
	
	HashMap<String, String> GetExpressCheckoutDetails(String token, SubsConfiguration sconfig) throws Exception;
		
	HashMap<String, String> CreateRecurringPaymentsProfile(String token, String payerID, SubsConfiguration sconfig) throws Exception;
		
	HashMap<String, String> UpdateRecurringPaymentsProfile(String profileID, SubsConfiguration sconfig) throws Exception;
	
	HashMap<String, String> UpdateRecurringPaymentsProfileReactive(String profileID, SubsConfiguration sconfig) throws Exception;
	
	HashMap<String, String> UpdateRecurringPaymentsProfileCancel(String profileID, SubsConfiguration sconfig) throws Exception;
}
