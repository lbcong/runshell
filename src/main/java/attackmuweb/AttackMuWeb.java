/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attackmuweb;

import Utils.ProxyWithSSH;
import Utils.SSHService;
import Utils.SshInfo;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Alex
 */
public class AttackMuWeb {

    /**
     * @param args the command line arguments
     */
    public void startProxy(ProxyWithSSH proxyWithSSH) {
        try {
            proxyWithSSH.setting(System.getProperty("user.dir") + File.separator + "ssh.txt", 1080);
            proxyWithSSH.start();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
