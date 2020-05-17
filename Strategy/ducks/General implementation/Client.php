<?php

require 'Stategy.php';
require 'ConcreteStrategyA.php';
require 'ConcreteStrategyB.php';
class Client
{
    private $strategy;
    function  __construct(Stategy $strategy)
    {
        $this->strategy =$strategy;
    }

    function set_strategy(Stategy $strategy)
    {
        $this->strategy =$strategy;
    }

    function do_some_logic()
    {
        $this->strategy->doAlgorithm();
    }
}

$client = new Client(new ConcreteStrategyA());
$client->do_some_logic(); // ASC Sort

$client ->set_strategy(new ConcreteStrategyB());
$client->do_some_logic(); // DESC Sort