package com.prjfoody.foody.parser;

import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.domain.define.SessionAttributes;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class UserFromRequest {

    public Users convert(HttpServletRequest request){
        HttpSession session = request.getSession();
        Object sessionId = session.getAttribute(SessionAttributes.ID.name());

        if(sessionId != null){
            return ((Users) sessionId);
        }

        return null;
    }
}
