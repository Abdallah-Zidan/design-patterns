<?php 
/*
App -> English--> DefaultLang

    ---> Adapter ->> English -> Adapter
                                Arabic --> Arabic 

    overwrite-==>   defaultLoc--->   Arabic       
    
    compostition===>  
    delegation

*/

class DefaultLang
{
    public function defaultLoc():string
    {
        return "Default is : English";
    }
}

class ArabicLang
{
    public function Arabic():string
    {
       return "Default is :Arabic";
    }
}

class Adapter extends DefaultLang
{
    protected $arabiclang;
    ////-> 1-$var=new ArabicLang()
    //////new Adapter($var)
    public function __construct(ArabicLang $lang)
    {
        $this->arabiclang=$lang;
    }
    ///Delegation --> call function from other class
    public function defaultLoc():string
    {
        return $this->arabiclang->Arabic();
    }

}

function ClientChoice(DefaultLang $lang)
{
    echo $lang->defaultLoc();
}

//1- open app
$openApp=new DefaultLang();
//2- echo defaultLoc()
ClientChoice($openApp);
echo "\n";
//3- slecet lang 
//arabic
$arab=new ArabicLang();
//adapter
$adapter=new Adapter($arab);
//4-echo defaultLoc()
ClientChoice($adapter);

echo "\n";

?>