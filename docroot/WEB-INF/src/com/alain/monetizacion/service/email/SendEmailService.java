package com.alain.monetizacion.service.email;

import com.alain.monetizacion.model.SubsConfiguration;

public interface SendEmailService {

	void sendEmailJustAction(String userEmail, SubsConfiguration subsConfiguration, String action) throws Exception;

}
