package com.shushi.spring.blog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author anhbt 9/5/2019
 * com.shushi.spring.blog
 */
public abstract class TestStream {
    private Installed installed;

    public Installed getInstalled() {
        return installed;
    }

    public void setInstalled(Installed installed) {
        this.installed = installed;
    }

    public static class Installed {
        private List<String> redirect_uris;
        private String client_secret;
        private String auth_provider_x509_cert_url;
        private String token_uri;
        private String auth_uri;
        private String project_id;
        private String client_id;

        public List<String> getRedirect_uris() {
            return redirect_uris;
        }

        public void setRedirect_uris(List<String> redirect_uris) {
            this.redirect_uris = redirect_uris;
        }

        public String getClient_secret() {
            return client_secret;
        }

        public void setClient_secret(String client_secret) {
            this.client_secret = client_secret;
        }

        public String getAuth_provider_x509_cert_url() {
            return auth_provider_x509_cert_url;
        }

        public void setAuth_provider_x509_cert_url(String auth_provider_x509_cert_url) {
            this.auth_provider_x509_cert_url = auth_provider_x509_cert_url;
        }

        public String getToken_uri() {
            return token_uri;
        }

        public void setToken_uri(String token_uri) {
            this.token_uri = token_uri;
        }

        public String getAuth_uri() {
            return auth_uri;
        }

        public void setAuth_uri(String auth_uri) {
            this.auth_uri = auth_uri;
        }

        public String getProject_id() {
            return project_id;
        }

        public void setProject_id(String project_id) {
            this.project_id = project_id;
        }

        public String getClient_id() {
            return client_id;
        }

        public void setClient_id(String client_id) {
            this.client_id = client_id;
        }
    }

    public static void main(String[] args) {
        List<String> t = new ArrayList<>();
        t.add("Peter");
        t.add("Peter Park");
        t.add("Peter Hau");
        t.add("Peter Hai");
        t.add("Peter Phuong");
        List<String> a = t.stream().filter(x -> x.contains("Hai")).collect(Collectors.toList());
        System.out.println(a.get(0));
    }

}
