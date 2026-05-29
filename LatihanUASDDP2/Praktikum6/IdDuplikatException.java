package LatihanUASDDP2.Praktikum6;

public class IdDuplikatException extends Exception {
    public IdDuplikatException(String id) {
        super("Id yang dimasukkans udah ada");
    }
    
}
