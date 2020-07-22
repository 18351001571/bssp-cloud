package com.cloud.bssp.auth.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * OAuth2授权配置类
 */
@Configuration
@EnableAuthorizationServer
@AllArgsConstructor
public class OauthServerConfig extends AuthorizationServerConfigurerAdapter {

    private DataSource dataSource;

    private UserDetailsService userDetailsService;

    private AuthenticationManager authenticationManager;

    private PasswordEncoder passwordEncoder;

    /**
     * Description: 从数据库中查询出客户端信息
     * Created date: 2020/7/22
     * @return org.springframework.security.oauth2.provider.client.JdbcClientDetailsService
     * @author weirx
     */
    @Bean
    public JdbcClientDetailsService clientDetailsService() {
        JdbcClientDetailsService jdbcClientDetailsService = new JdbcClientDetailsService(dataSource);
        jdbcClientDetailsService.setPasswordEncoder(passwordEncoder);
        return jdbcClientDetailsService;
    }

    /**
     * Description: token保存策略
     * Created date: 2020/7/22
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     * @author weirx
     */
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    /**
     * Description: 授权信息保存策略
     * Created date: 2020/7/22
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     * @author weirx
     */
    @Bean
    public ApprovalStore approvalStore() {
        return new JdbcApprovalStore(dataSource);
    }

    /**
     * Description: 授权码模式专用对象
     * Created date: 2020/7/22
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     * @author weirx
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    /**
     * Description: 指定客户端登录信息来源
     * Created date: 2020/7/22
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     * @author weirx
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //从数据库取数据
        clients.withClientDetails(clientDetailsService());

        // 从内存中取数据
//        clients.inMemory()
//                .withClient("baidu")
//                .secret(passwordEncoder.encode("12345"))
//                .resourceIds("product_api")
//                .authorizedGrantTypes(
//                        "authorization_code",
//                        "password",
//                        "client_credentials",
//                        "implicit",
//                        "refresh_token"
//                )// 该client允许的授权类型 authorization_code,password,refresh_token,implicit,client_credentials
//                .scopes("read", "write")// 允许的授权范围
//                .autoApprove(false)
//                //加上验证回调地址
//                .redirectUris("http://www.baidu.com");
    }

    /**
     * Description: 检测token的策略
     * Created date: 2020/7/22
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     * @author weirx
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.allowFormAuthenticationForClients()    //允许form表单客户端认证,允许客户端使用client_id和client_secret获取token
                .checkTokenAccess("isAuthenticated()")     //通过验证返回token信息
                .tokenKeyAccess("permitAll()")            // 获取token请求不进行拦截
                .passwordEncoder(passwordEncoder);
    }

    /**
     * Description: OAuth2的主配置信息
     * Created date: 2020/7/22
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     * @author weirx
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .approvalStore(approvalStore())
                .authenticationManager(authenticationManager)
                .authorizationCodeServices(authorizationCodeServices())
                .tokenStore(tokenStore())
                .userDetailsService(userDetailsService);
    }
}