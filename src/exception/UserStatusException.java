package exception;

/**
 * 用户状态异常
 * @author 李恒
 *
 */
public class UserStatusException extends Exception {

	public UserStatusException() {
	}

	public UserStatusException(String message) {
		super(message);
	}

	public UserStatusException(Throwable cause) {
		super(cause);
	}

	public UserStatusException(String message, Throwable cause) {
		super(message, cause);
	}

}
