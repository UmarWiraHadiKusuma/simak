package com.rifaz.simak;

public class Model {
    public String nama;
    public int nim;
    public String email;
    public String username;
    public String password;
    public int get;

    public Model(String nama, int nim , String email, String username, String password, int get) {

        this.nama = nama;
        this.nim = nim;
        this.email = email;
        this.username = username;
        this.password = password;
        this.get = get;
        
    }
    
    public Model(){
    }
}
