package exception;

public class CampoObligatorio extends Throwable {
    public CampoObligatorio(String mensaje) {
        super(mensaje);
    }
}
