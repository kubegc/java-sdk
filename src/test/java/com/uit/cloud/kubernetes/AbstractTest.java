package com.uit.cloud.kubernetes;

/*
 * Copyright (2019, ) Institute of Software, Chinese Academy of Sciences
 */

import com.github.kubesys.kubernetes.ExtendedKubernetesClient;
import com.github.kubesys.kubernetes.api.model.*;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;

import java.util.*;

/**
 * @author wuheng@otcaix.iscas.ac.cn
 * @author wuyuewen@otcaix.iscas.ac.cn
 * @author liuhe@otcaix.iscas.ac.cn
 *
 * @version 1.3.0
 * @since   2019/9/3
 *
 */
public class AbstractTest {

    public static Config config = new ConfigBuilder()
            .withApiVersion("v1")
            .withCaCertData("LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUN5RENDQWJDZ0F3SUJBZ0lCQURBTkJna3Foa2lHOXcwQkFRc0ZBREFWTVJNd0VRWURWUVFERXdwcmRXSmwKY201bGRHVnpNQjRYRFRJd01Ea3lNakF4TXpZeU1Gb1hEVE13TURreU1EQXhNell5TUZvd0ZURVRNQkVHQTFVRQpBeE1LYTNWaVpYSnVaWFJsY3pDQ0FTSXdEUVlKS29aSWh2Y05BUUVCQlFBRGdnRVBBRENDQVFvQ2dnRUJBTFZsCkFzU1NWV25hYXJXRkNnbExJMlRzTGNKcmZjSGxLSG91ZUVpUUx5TERabW9vOEkwY2VLNjlWY3ZQamExSGwyWDUKWDQvTERKTzh0TlVKWFl1TCtMMHV1dkg2Ym5EdUdCK3V1YS9BTFUwSHE1WmZPZVdlelVkVWZIQlVaWWZZNjFoTApyQ2YrbWRhKzFXUUJSSmtnMFV2UnhCNnZSRkhpVVlZWGN3TWx0MitsTC9qQ3hPekFsL3RxWDBYS0RYS3RjNUQ3CnRxRktkM2I0c0JYUUdrT0UrWVVER1A2d0hIUmhsOWY2cU95ZjNFMFVvVkhQZjA5cmMvNFI2aFpIUklFcERBVVUKZTFsQnY3blJPY0xobzNGcFFabDJZR1U0L1liMUVWcFNEMFZ0eUpnM1hsTHNoLzlLYmFDS3MvdTJWanZva3JGZApHelMvaVlaOTFFVERwUmlkcWo4Q0F3RUFBYU1qTUNFd0RnWURWUjBQQVFIL0JBUURBZ0trTUE4R0ExVWRFd0VCCi93UUZNQU1CQWY4d0RRWUpLb1pJaHZjTkFRRUxCUUFEZ2dFQkFHZ3FLODRFQU9wZVl0ZTFPU3VTclZvZmdrbFQKa1h2ZWY2NnFOZDJaMmg2WHRlK29LbFFZTHZDaVRWOGhBYnFVVzFFYmcxZ2dLM3B0bzZsNlIzUjFsNklteXlDMwp2UTUwUzdsenFKTDYvL2lLMFNxdGYxOXhyL0cvb1YzNUFPQ3lTQm1qUnN2T0dNY2JHZENNc1FSdTJmSEVWZU4xCm5lQng4NkZZY1lvWTJubDE3VmNhdDcyWTJCcVRDbjlqZ2E0UDgwVS9mRUQwdXE0MGZvQ2NYd1hpOXpCY3RVSGcKdTVEZGdoKzNGcGdMK2pPamRGQmIweTNYa0RxaUE1L0hldEd0eVliMUl4Y1Nsd3RldGRkRlFQblZjbXByQU9hRQphS0R2MTQzMjQ1aEpFS3FPaGgwSHRSaGk3VkdrTTBNL1hIOVBHR3BBd1hKb3FyOEtRQjU0OCsxdlFhaz0KLS0tLS1FTkQgQ0VSVElGSUNBVEUtLS0tLQo=")
            .withClientCertData("LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUM4akNDQWRxZ0F3SUJBZ0lJQ05sOE4zMTBGaTR3RFFZSktvWklodmNOQVFFTEJRQXdGVEVUTUJFR0ExVUUKQXhNS2EzVmlaWEp1WlhSbGN6QWVGdzB5TURBNU1qSXdNVE0yTWpCYUZ3MHlNVEE1TWpJd01UTTJNalJhTURReApGekFWQmdOVkJBb1REbk41YzNSbGJUcHRZWE4wWlhKek1Sa3dGd1lEVlFRREV4QnJkV0psY201bGRHVnpMV0ZrCmJXbHVNSUlCSWpBTkJna3Foa2lHOXcwQkFRRUZBQU9DQVE4QU1JSUJDZ0tDQVFFQW9WK0ZBaVlzdWg2VS96Y0cKekI0SmhjeHpZUGt4WGErWm84SnZkRDgvQmdodCtWbi92YnB5NTJzcWY3dFdOWE1kckw3SWNtWXcyTjlHMld0OAp6NGFpVVN4aGRmMUxIZGdrT0k0L0JyeUQ2cyt2Zk1ueFZKY0c2RVdMWURnTkpkOHpkR1Z0enYrTDFtK2RsbUMxCm1NeEtlNnMwRWhGUHJjbk9ONU5lZllJUU10VTFTUG9zWGVDYkFQalRac0MrcUloNDNmTzZPUVFQNnk5YmJTVjQKTERscDUwTlBPZjBlZml5bUZLUkc3RUJEOGFwUGlVRlk2M3k5WFI4YmEvMlhCZk5QSW8rbjRiVDljUCs5UXk2MApsVytSOVJ0YlpqbUxpTUlZbHhkQStPaEp2Rzh1SUVhK3J6VzBEcnJpN1EyQ1NpN3BOd2ZlQkV2bWZxQ3YyQUloCmJMYlNKUUlEQVFBQm95Y3dKVEFPQmdOVkhROEJBZjhFQkFNQ0JhQXdFd1lEVlIwbEJBd3dDZ1lJS3dZQkJRVUgKQXdJd0RRWUpLb1pJaHZjTkFRRUxCUUFEZ2dFQkFIWENrbytGZG1KeU4wWnVWL3NuajRxMUpJVWkxTXoxdmZwMQowWkU1cExJcnVoQmlWNTYzaTh1UUNUKzhvMG9HQjNsa0NVZVN4bUZnc3NheDBKb2lFTkNwK01xakR6RE0yVm9jCkhtNmxsTWVsWndXekdMc2tya2ovSzAwNEYwMldnM25vc0UzN3RacWJwSENPRjJONlVOOXZKeWVISlZaUVo2WDIKNHU5QnZHR2F5akt0WGdWS1dYeHRFYktOdmNWa21Wd0VkOTBZQjhnMmNSWFIyUFNnZ2IrOW1ybjFvTitYWkNmWgpMNlhkNHRPY2RqNFlYOHpBOVJ1UDhqWW5PVS9SK3NEZmJMWlhEMlE4bDVQNFlHUHFBSHZrdm83UGpzc3NwT3MrClRQNi9ucnhhajUrY0RhcXMvekoyUkcxTnRkM1RlTHAzRUkzUzVodldiR2JQUHBYWk1Iaz0KLS0tLS1FTkQgQ0VSVElGSUNBVEUtLS0tLQo=")
            .withClientKeyData("LS0tLS1CRUdJTiBSU0EgUFJJVkFURSBLRVktLS0tLQpNSUlFb3dJQkFBS0NBUUVBb1YrRkFpWXN1aDZVL3pjR3pCNEpoY3h6WVBreFhhK1pvOEp2ZEQ4L0JnaHQrVm4vCnZicHk1MnNxZjd0V05YTWRyTDdJY21ZdzJOOUcyV3Q4ejRhaVVTeGhkZjFMSGRna09JNC9CcnlENnMrdmZNbngKVkpjRzZFV0xZRGdOSmQ4emRHVnR6ditMMW0rZGxtQzFtTXhLZTZzMEVoRlByY25PTjVOZWZZSVFNdFUxU1BvcwpYZUNiQVBqVFpzQytxSWg0M2ZPNk9RUVA2eTliYlNWNExEbHA1ME5QT2YwZWZpeW1GS1JHN0VCRDhhcFBpVUZZCjYzeTlYUjhiYS8yWEJmTlBJbytuNGJUOWNQKzlReTYwbFcrUjlSdGJaam1MaU1JWWx4ZEErT2hKdkc4dUlFYSsKcnpXMERycmk3UTJDU2k3cE53ZmVCRXZtZnFDdjJBSWhiTGJTSlFJREFRQUJBb0lCQURDK2Zack1sUzRURnNhUQpoSWtiZVp6a3lPVTk0RitBTDFSNzR0YW1WQThxZEsyaE5kTEZndmZNTXlZcUhEeEE3WEhFbngrUEpxb2JwM2I5Ck5OSXF4TlRvSnZoUTdtT3hhaDk3T0NaOHd3d21kOGVsNkRPNCt1a21PSmR6MXVUZHF0azUyaFZ3czNpdWRsZDYKRnVCMHRQcnVGK2h0T2pnd2dRM2dnZVkvWjAwekJ0cWkxTU1PckY0RkkyQ0VGUnZUNUJLWDFOYkUzN0VMSEhadApGckhnUkNydlI1ZDFFV1NHa21oTitVSE0zUHFPMVFtR0Z3aGxsYldjbmJTZ28ycm1CYm0vK0xUeWd5dVlDMlY2ClZoZnNrbWpWbzlLZ2QyTVhBRG56T2twRG9lMWQ2WElXUzA0TXRHWXRzelNqYXlnUUVkWGNvbGVsTjdhbjFhVlIKQkp2K1hYRUNnWUVBMVVvYU1XczZVUlJOZHFjVk9sUE5GYkN3djZmamtPdklWYkN2Tk1jOFdFU2hlMkY5U3RiQwpGeEc5cWpUWVc2K0dBOTExWklodktENDhFdVBZOWZqSkdpVmsxWS9sL3BsSk80S3R4cHJBazBRRDZYcGtXRFhvCjBQUGYwU0lETithSzc2dVB6ZHJTVmIyOHBDL1dGUGxxWWxPSEFEZHlMUVE0MmNrMzZoZkVCVmNDZ1lFQXdiQUYKTGlJL0RFR1dNQWpmSHIwMWQwUklHMjZhT3lod0cyUGlYQWU4c1h2bE1pbFhVQ1JKaEx0b2lDRzYvMk5hZGF0WApxZXN4TWhLWTZwMytXWjhmSVJPbGwxYVQzb21RQ05oR28xdllaZ1orUldGYXJ2VllseUZ3WXNqblNwNll5ZW5oCmk5cFdNcXcycVhtRjJVY2F5TGFGS0R1TnBEaEFkN0VUcFBzMjJ1TUNnWUFvb1FrRVNPeSs3U01rYXdkOEtPSjAKTTBnMytmODdaKzZ0aEE2Yit5ZmZtSk02TVlQd2NhQmZUSjNZZ21DRWRwY012VzdUUzdvQTdIbjlEeklSQ09jbAo5K0dSWE92dTU3d3ZmZUVrWis0dkgxR3ZkQVVSV0pPVTJoL1VjcW95UjlSSGUyTFZUODJwVDQ5VHAxa2NmYlpxCkxJY1czM2o4WWtXQ0Z2Wnp2VHMxMlFLQmdRQ2xVbHdwazV1akYzeGRSY1ZFbEpYRlZtZ0IyamNWRmFBVEVQL08KTStCdzBlTEJIUjVrem9SZUlpVElSWm82a1JCT2JkRG12VlNCZS9SQUZsbGJJQUhQRnRqNXd6RjErbzhScmFFbApvS2lsOVJia200TnU0UVljQWJQTzdkTFdFMmN3dVV3R05uZnF5cW5ob0ZPS01USUFiaUpjUS9EVFloeE16YjJKCnpjOTFwd0tCZ0UvdHhEdFJYVExBc2xSODkzZWhBMEZqVWpvaTZzQzVDSW9PK0kwemNqa3Urb2Y4eTFHOTNWbTYKSHhSa05uZVAyZFhLZVkxN0NSMDRoM3pYS0ZnbG1McDFSL2swVDcxaFoxb21XT1dWd2lvYURrLzgwSE42RzBISApDY0VqN3l6Mm4wRURwQ05EaHU4WjVSckU4R3BCTVhOelQxbUNMdEROQ1MvOXNjcTVpUUxNCi0tLS0tRU5EIFJTQSBQUklWQVRFIEtFWS0tLS0tCg==")
            .withMasterUrl("https://133.133.135.32:6443")
            .build();

    public static ExtendedKubernetesClient getClient() throws Exception {
        return new ExtendedKubernetesClient(config);
    }

    public static VirtualMachine getVMByName(String name) throws Exception {
        return getClient().virtualMachines().get(name);
    }

    public static VirtualMachineBackup getVMBByName(String name) throws Exception {
        return getClient().virtualMachineBackups().get(name);
    }

    public static List<VirtualMachineBackup> getVMBList() throws Exception {
        return getClient().virtualMachineBackups().list().getItems();
    }

    public static List<VirtualMachineBackup> getVMBList(String domain) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("domain", domain);
        return getClient().virtualMachineBackups().list(map).getItems();
    }

    public static VirtualMachineImage getVMImageByName(String name) throws Exception {
        return getClient().virtualMachineImages().get(name);
    }

    public static VirtualMachineDisk getVMDiskByName(String name) throws Exception {
        return getClient().virtualMachineDisks().get(name);
    }

    public static VirtualMachinePool getVMPoolByName(String name) throws Exception {
        return getClient().virtualMachinePools().get(name);
    }

    public static VirtualMachineDiskImage getVMDiskImageByName(String name) throws Exception {
        return getClient().virtualMachineDiskImages().get(name);
    }

    public static VirtualMachineNetwork getVMNetworkByName(String name) throws Exception {
        return getClient().virtualMachineNetworks().get(name);
    }
}
