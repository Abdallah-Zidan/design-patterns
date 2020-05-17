<?php
abstract Class Duckk
{
   abstract protected function display();
    abstract protected  function fly();
}
class DuckType1 extends Duckk
{
    public function display()//normal display
    {
        // TODO: Implement display() method.
    }
    public function fly() //super fly
    {
        // TODO: Implement fly() method.
    }
}

class DuckType2 extends Duckk
{
    public function display()//super display
    {
        // TODO: Implement display() method.
    }
    public function fly() //normal fly
    {
        // TODO: Implement fly() method.
    }
}

class DuckType3 extends Duckk
{
    public function display()//normal display -> redundancy
    {
        // TODO: Implement display() method.
    }
    public function fly() //normal fly - > redundancy
    {
        // TODO: Implement fly() method.
    }
   
}


