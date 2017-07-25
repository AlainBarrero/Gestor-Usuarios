package com.alain.monetizacion.service.paypal;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.alain.monetizacion.model.PayPal;
import com.alain.monetizacion.model.SubsConfiguration;
import com.alain.monetizacion.service.PayPalLocalServiceUtil;


public class ExpressCheckoutServiceImpl implements ExpressCheckoutService{
	
	public ExpressCheckoutServiceImpl(){}
	
	
	/*
	 * El método crea la conexión entre el cliente y el servidor PayPal
	 */
	@Override
	public HashMap<String, String> SetExpressCheckoutRecurringPayments(String returnURL, String cancelURL, SubsConfiguration sconfig)
			throws Exception {		
		String currencyCodeType = "EUR"; 
		
		String billingType = "RecurringPayments";
		String billingAgreementDescription = sconfig.getDescription();
		
		String nvpstr = "&L_BILLINGTYPE0=" + billingType + "&L_BILLINGAGREEMENTDESCRIPTION0=" + billingAgreementDescription + "&ReturnUrl=" + URLEncoder.encode( returnURL, "UTF-8" ) + "&CANCELURL=" + URLEncoder.encode( cancelURL, "UTF-8" ) + "&PAYMENTREQUEST_0_CURRENCYCODE=" + currencyCodeType;
		
		HashMap<String, String> nvp = httpcall("SetExpressCheckout", nvpstr,sconfig);
		return nvp;
	}

	
	
	/*
	 * El método obtiene los detalles de la transacción
	 */
	@Override
	public HashMap<String, String> GetExpressCheckoutDetails(String token,  SubsConfiguration sconfig) throws Exception {
		String nvpstr= "&TOKEN=" + token;
		
		HashMap<String, String> nvp = httpcall("GetExpressCheckoutDetails", nvpstr, sconfig);		
		return nvp;
	}
	
	
	/*
	 * El método crea el perfil de los suscriptores
	 */
	@Override
	public HashMap<String, String> CreateRecurringPaymentsProfile(String token, String payerID, SubsConfiguration sconfig)
			throws Exception {
		
		ZonedDateTime profileStartDate = ZonedDateTime.now( ZoneOffset.UTC );
		
		String billingAgreementDescription = sconfig.getDescription();
		
		String billingPeriod = sconfig.getCycle();
		String billingFrecuency = String.valueOf(sconfig.getTime());		
		String maxFailedPayments = "2";	

		String currencyCodeType = "EUR";
		String countryCode = "ES";	
		
		String amount = String.valueOf(sconfig.getAmount());
		
		String nvpstr  = "&TOKEN=" + token + "&PAYERID=" + payerID + "&AMT=" + amount + "&PROFILESTARTDATE=" + profileStartDate + "&DESC=" + billingAgreementDescription;
		nvpstr = nvpstr + "&BILLINGPERIOD=" + billingPeriod + "&BILLINGFREQUENCY=" + billingFrecuency + "&CURRENCYCODE=" + currencyCodeType + "&COUNTRYCODE=" + countryCode + "&MAXFAILEDPAYMENTS=" + maxFailedPayments;
	
		String itemQty0 = "1";
		String itemName0 = "Kitty Antics";
		String itemCategory0 = "Digital";				
		String itemAmt0 = amount;
		
		nvpstr = nvpstr + "&L_PAYMENTREQUEST_0_ITEMCATEGORY0=" + itemCategory0 + "&L_PAYMENTREQUEST_0_NAME0=" + itemName0 + "&L_PAYMENTREQUEST_0_QTY0=" + itemQty0 + "&L_PAYMENTREQUEST_0_AMT0=" + itemAmt0;

		
		HashMap<String, String> nvp = httpcall("CreateRecurringPaymentsProfile", nvpstr, sconfig);
		return nvp;
	}
	
	
	
	
	/*
	 * El método actuializa la suscripción del usuario
	 */
	@Override
	public HashMap<String, String> UpdateRecurringPaymentsProfile(String profileID, SubsConfiguration sconfig) throws Exception {
		String nvpstr= "&PROFILEID=" + profileID + "&ACTION=Suspend";
		
		HashMap<String, String> nvp = httpcall("ManageRecurringPaymentsProfileStatus", nvpstr, sconfig);		
		return nvp;
	}
	
	
	/*
	 * El método actuializa la suscripción del usuario activandolo de nuevo
	 */
	@Override
	public HashMap<String, String> UpdateRecurringPaymentsProfileReactive(String profileID, SubsConfiguration sconfig) throws Exception{
		String nvpstr= "&PROFILEID=" + profileID + "&ACTION=Reactivate";
		
		HashMap<String, String> nvp = httpcall("ManageRecurringPaymentsProfileStatus", nvpstr, sconfig);		
		return nvp;
	}
	
	
	
	/*
	 * El método cancela la suscripción del usuario activandolo de nuevo
	 */
	@Override
	public HashMap<String, String> UpdateRecurringPaymentsProfileCancel(String profileID, SubsConfiguration sconfig) throws Exception{
		String nvpstr= "&PROFILEID=" + profileID + "&ACTION=Cancel";
		
		HashMap<String, String> nvp = httpcall("ManageRecurringPaymentsProfileStatus", nvpstr, sconfig);		
		return nvp;
	}
	
	
	/*
	 * El método crea la llamada http
	 */
	private HashMap<String, String> httpcall( String methodName, String nvpStr, SubsConfiguration sconfig) throws Exception{
		PayPal paypal = PayPalLocalServiceUtil.findByConfigurationId(sconfig.getConfigurationId());

		String agent = "Mozilla/4.0";
		String respText = "";
		HashMap<String, String> nvp = null;
		
		String gv_APIUserName = paypal.getPaypalUser();
		String gv_APIPassword = paypal.getPaypalPassword();
		String gv_APISignature = paypal.getPaypalFirm();
		
		String gv_APIEndpoint = "https://api-3t.sandbox.paypal.com/nvp";
		String gv_Version = "93";
		
		String encodedData = "METHOD=" + methodName + "&VERSION=" + gv_Version + "&PWD=" + gv_APIPassword + "&USER=" + gv_APIUserName + "&SIGNATURE=" + gv_APISignature + nvpStr;
		
		URL postURL = new URL( gv_APIEndpoint );
		HttpURLConnection conn = (HttpURLConnection)postURL.openConnection();
		
		conn.setDoInput (true);
		conn.setDoOutput (true);
		
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		conn.setRequestProperty( "User-Agent", agent );

		conn.setRequestProperty( "Content-Length", String.valueOf( encodedData.length()) );
		conn.setRequestMethod("POST");
		
		DataOutputStream output = new DataOutputStream( conn.getOutputStream());
		output.writeBytes( encodedData );
		output.flush();
		output.close ();
		
		int rc = conn.getResponseCode();
		if ( rc != -1){
			BufferedReader is = new BufferedReader(new InputStreamReader( conn.getInputStream()));
			String _line = null;
			while(((_line = is.readLine()) !=null)){
				respText = respText + _line;
			}
			nvp = deformatNVP(respText);
		}

		
		return nvp;
	}
	
	
	
	/*
	 * El método crea el formato NVP
	 */
	private HashMap<String, String> deformatNVP(String pPayload) throws UnsupportedEncodingException{
		HashMap<String, String> nvp = new HashMap<String, String>();
		StringTokenizer stTok = new StringTokenizer(pPayload, "&");
		while (stTok.hasMoreTokens()){
			
			StringTokenizer stInternalTokenizer = new StringTokenizer( stTok.nextToken(), "=");
			if (stInternalTokenizer.countTokens() == 2){
				
				String key = URLDecoder.decode( stInternalTokenizer.nextToken(), "UTF-8");
				String value = URLDecoder.decode( stInternalTokenizer.nextToken(), "UTF-8");
				nvp.put( key.toUpperCase(), value );
			}
		}
		return nvp;
	}

}
