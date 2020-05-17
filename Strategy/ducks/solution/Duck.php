<?php
require 'DisplayStrategy.php';
require 'NormalDisplayStrategy.php';
require 'SuperDisplayStrategy.php';
require 'FlyStrategy.php';
require 'SuperFlyStrategy.php';
require 'NormalFlyStrategy.php';
class Duck
{
    private $display_strategy;
    private $fly_strategy;

    public function __construct(DisplayStrategy $display_strategy, FlyStrategy $fly_strategy)
    {
        $this->display_strategy = $display_strategy;
        $this->fly_strategy = $fly_strategy;
    }

    public function display()
    {
        $this->display_strategy->doAlgorithm();
    }
    public function fly()
    {
        $this->fly_strategy->doAlgorithm();
    }
    public function set_display(DisplayStrategy $display_strategy)
    {
        $this->display_strategy = $display_strategy;
    }
    public function set_fly(FlyStrategy $fly_strategy)
    {
        $this->fly_strategy = $fly_strategy;
    }
}

$duck_type1= new Duck(new NormalDisplayStrategy() , new SuperFlyStrategy());
$duck_type1->display();
$duck_type1->fly();
echo "-----------------------".PHP_EOL;

$duck_type2= new Duck(new SuperDisplayStrategy() , new NormalFlyStrategy());
$duck_type2->display();
$duck_type2->fly();
echo "-----------------------".PHP_EOL;


$duck_type3= new Duck(new NormalDisplayStrategy() , new NormalFlyStrategy());
$duck_type3->display();
$duck_type3->fly();
echo "-----------------------".PHP_EOL;



$duck_type3->set_display(new SuperDisplayStrategy());
$duck_type3->set_fly(new SuperFlyStrategy());
$duck_type3->display();
$duck_type3->fly();
