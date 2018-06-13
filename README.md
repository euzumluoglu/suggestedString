# string suggestion

## suggest string based on customer input and filters

it should be suggested some alternative sentence based on user input. Some fields are mask based on word lenght and masked list.

there is a limitation like max 3 words lenght.

word size should be longer than 1 characher.

word should not be in masked list.

## sample input of the user
{"The","weather","is","nice",".","Nobody","likes","to","stay","at","home","in","these","days",".","You","should","go","outside","too","."};


## sample mask list
{"the",".","yes","no","and","is","at","in","to"}

## sample size limatation
max_word_size = 3

## expceted suggestion list
weather
nice
Nobody
Nobody likes
likes
stay
home
these
these days
days
You
You should
You should go
should
should go
should go outside
go
go outside
go outside too
outside
outside too
too

## expected method implementation

    // original one with Iterator<String> searchIterator
    public static List<String> suggestedMessages(List<String> searchList, Set<String> maskedSet){

    }
