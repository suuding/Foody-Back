package com.prjfoody.foody.modules;

import com.prjfoody.foody.domain.Users;
import com.prjfoody.foody.domain.abstracts.Stuff;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Validation {

    public Boolean validUser(Users user) {
        return true;

        // 이게 진짜 필요함??
        /* todo
            1. UserRepository 생성 후
            2. 인자값의 user와 UserRepository에서 조회한 user를 비교
         * */

        //return false;
    }

    /*
            Product product = new Product();
            ArrayList<Stuff> stuffs = new ArrayList<>();
            stuffs.add(product);
            validation.validOwnStuff(stuffs, user);
     */
    public Boolean validOwnStuff(Stuff target, Users user){
        return true;
        /*
        if (target.getOwner().getId().equals(user.getId()))
            return true;

        return false;

         */
    }
}
