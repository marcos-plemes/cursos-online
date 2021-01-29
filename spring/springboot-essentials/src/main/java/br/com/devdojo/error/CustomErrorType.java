package br.com.devdojo.error;

public class CustomErrorType {
    
    private final String errorMessage;
    
    public CustomErrorType(final String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage() {
        return this.errorMessage;
    }
    
}
