package model;
public class Login 
{
private String name, password;
public Login(){}

public Login(String name, String password)
{
    this.name=name;
    this.password= password;
}

public String getName()
{
    return name;
}

public void setName(String name)
{
this.name=name;
}

public String getPassword()
{
 return password;
}

public void setPassword(String pwd)
{
this.password=pwd;
}


public boolean equals(Object o)
{

Login l=(Login)o;


if(name.equals(l.getName())&& password.equals(l.getPassword()))
    return true;
else 
    return false;
 }

}
