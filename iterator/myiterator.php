<?php

interface MyIterator
{
    public function hasNext();
    public function next();
}

class NameIterator implements MyIterator
{
    public $key=0;
    private $names;

    public function __construct($names)
    {
        $this->names=$names;   
    }
    public function hasNext()
    {
        if($this->key < count($this->names))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public function next()
    {
        if($this->hasNext())
        { 
            return $this->names[$this->key++];
        }
        return null;
    }
       
}

interface myContainer
{
    public function getMyIterate():MyIterator;
    public function text():string;
}

class NameRepository implements myContainer
{
    public $names=array("Robert" , "John" ,"Julie" , "Lora");

    public function text():String
    {
        return "HI";
    }

    public function getMyIterate():MyIterator
    {
        return new NameIterator($this->names);
    }
    
}



$nameRepo=new NameRepository();
$iter=$nameRepo->getMyIterate();
for($iter; $iter->hasNext();){
    $name = $iter->next();
    echo("Name : " + $name);
 } 	
?>