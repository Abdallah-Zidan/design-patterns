<?php

interface calling{
  public function call();
}
class DSL implements calling
{
    public function call()
    {
       echo "From DSL";
    }
}

class mobile implements calling
{
    protected $calling;
    
    public function __construct(calling $calling)
    {
        $this->calling = $calling;
    }

    
    //function of call
    public function call()
    {
        return $this->calling->call();
    }

}
class FB extends mobile
{
    public function call_solider()
    {
        return "mobile(" . parent::operation() . ")";
    }
}

$fb=new FB;