package com.dev.common.message;

import java.text.MessageFormat;

import com.dev.common.message.MessageGateway;

@Slf4j
@Component("messageSource")
public class DbAwareMessageSource extends AbstractMessageSource {
    
    private MessageGateway messageGateway;

    

    @Override
    protected MessageFormat resoveCode(String messageKey, Locale locale) {
        if(messageGateway == null){
            if(log.isDebugEnabled()){
                log.debug("messageGateway  initialized");
            }

            messageGateway = ApplicationContextProvider.getContext().getBean(MessageGateway.class);
        }
    }
}
