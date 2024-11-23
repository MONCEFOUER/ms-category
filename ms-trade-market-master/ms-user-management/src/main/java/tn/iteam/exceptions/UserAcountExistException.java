package tn.iteam.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserAcountExistException  extends RuntimeException{
    public UserAcountExistException(String message){
        super(message);
    }
}
