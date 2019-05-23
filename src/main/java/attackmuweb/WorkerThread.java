/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attackmuweb;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WorkerThread implements Runnable {

    private String user;
    private String pass;
    private Integer port;
    private String host;

    public WorkerThread(String host, String user, String pass) {
        this.user = user;
        this.pass = pass;
        this.port = 22;
        this.host = host;
    }

    public WorkerThread() {
        super();
    }

    @Override
    public void run() {
        try {
            Service s = new Service();
            s.sendGet();
        } catch (Exception ex) {
            Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
