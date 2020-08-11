package cn.hiczy.common.constants;

public class JwtConstant {

    /*密钥*/
    public static final String JWT_SECRET = "secret1234";
    /*签发人*/
    public static final String ISSUER = "bbs";


    /*以下是自定义的claims信息*/
    /*当前用户角色信息*/
    public static final String ROLES = "roles";
    /*当前用户所拥有的权限*/
    public static final String PERMISSIONS = "permissions";




}
