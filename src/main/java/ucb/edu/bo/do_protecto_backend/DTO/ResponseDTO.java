package ucb.edu.bo.do_protecto_backend.DTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseDTO {
    private static final Logger logger = LoggerFactory.getLogger(ResponseDTO.class);
    
    private String code;

    private Object result;

    private String messsage;

    /* Respuesta correcta 
     * @param result
    */
    public ResponseDTO(Object result) {
        this.code = "TASK-0000";
        this.result = result;

        logger.debug("Nueva instancia de ResponseDto creada:", result);

    }

     /* Error 
      * * @param code
      * @param message
     */
    public ResponseDTO(String code, String messsage) {
        this.code = code;
        this.messsage = messsage;

        logger.debug("Nueva instancia de ResponseDto creada:", messsage);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }

    @Override
    public String toString() {
        return "ResponseDto [code=" + code + ", result=" + result + ", messsage=" + messsage + "]";
    }
}