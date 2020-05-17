<?php 
/// Mail --> Accept / refuse --> mail --> Skype --> mobile ->fb/ws/tw
interface Mail
{
    function call():string;
}


//class DSL 
class Internet implements Mail
{
    public function call():string
    {
        return "You Have Internet And We Will Send By Skype";
    }
}
//mobile
class Mobile implements Mail
{   //wrapper ---> object --> mail
    protected $mail;//object fb->call

    public function __construct(Mail $mail)
    {
        $this->mail=$mail;
    }
    //call
    public function call():string
    {   //obj->call()
        $this->mail->call();
    }  
} 

//calss facebook --> 
class Facebook extends Mobile
{
    public function call():string
    {
        return "FaceBook Mail";
    }   
}

class Whatsapp extends Mobile 
{
    public function call():string
    {
        return "Whatsapp sent";
    }   
}

//for echo
function ClientChoice(Mail $mail)
{
    echo "RESULT: " . $mail->call();
}
/* 
$internet=new Internet;
ClientChoice($internet);

/* echo "\n";
$fb=new Facebook($internet);
ClientChoice($fb); */ 
//internet
$internet=new Internet;
//ClientChoice($internet);
echo "\n";
$Whatsapp=new Whatsapp($internet);
ClientChoice($Whatsapp);




?>