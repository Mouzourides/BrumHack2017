# BrumHack2017 - Leap Motion Projects!
BrumHack2017 Project(s) ***- Winners of 'Best Tech' (from Bloomberg) and 'Best Domain' (from MLH on behalf of domain.com)***

*by Sam Warner, Nikolas Mouzourides and Chloe Seivwright.*

## LeapTheremin
The LeapTheremin is a mock-theremin / whole host of different musical instruments all of which may be played in a theremin-like style.

It uses a [Leap Motion](www.leapmotion.com), their awesome Java API, and a Java-based [MIDI package](https://docs.oracle.com/javase/tutorial/sound/overview-MIDI.html).

These have all been tied together in an effort to make some music (or at least, loud noises).

### What the hell is a Theremin?!
This question was asked many times at BrumHack. Basically, it makes "weeewaaahhhwoooowaaa" noises, and can be played as a musical instrument. It is quite famous for being used in the Star Trek intro.

In theory, (if you were good enough) you could use this to make sounds as featured on this [Spotify playlist...](https://open.spotify.com/user/odasdelespacio/playlist/2LaWHSxITLAsLBXMmZbJ3z)

### A crash course in playing the theremin
So, we aren't 100% sure this is correct, but the way OUR theremin (and theremin-flavoured instruments) work is:
* Left hand palm elevation (i.e. y-plane) controls volume. A higher palm is loud, and a lower palm is quiet).
* Right hand's middle fingertip depth (i.e. z-plane) controls pitch. Closer produces a higher note, farther produces a lower note.

### To compile and run:
Change directory to `/src`
```cd /src```

Code to compile:
```javac -cp "../LeapJava.jar" Theremin.java```

Code to run:
```LD_LIBRARY_PATH=. java -cp ../LeapJava.jar:. Theremin```

...or, just set it up in your favourite IDE!

## LeapLocalRockPaperScissors
Now this one is probably a bit more correct than the theremin...

In the advent of intelligent personal assistants, we delegate more and more chores to these 'AI'. These range from the useful (check the weather, or remind me it's mum's birthday next Tuesday) to the somewhat silly (roll a 20-sided dice for me).

However, some people use these functions to make decisions simpler. If I flip a coin and it comes up heads, I'll do the vacuuming today instead of tomorrow.

But these disembodied voices are somewhat lackluster. 'Heads' or 'Tails' doesn't feel as real without flipping a coin, and 'Rock, Paper, Scissors' isn't as fun without throwing some shapes out there.

**This ends now.**

But more seriously, this 'Rock, Paper, Scissors' game (again) uses the [Leap Motion](www.leapmotion.com), their API, and some pretty basic Java.

### A crash course in Rock, Paper, Scissors
Nope, you don't need one.

### To compile and run:
Change directory to `/src`
```cd /src```

Code to compile:
```javac -cp "../LeapJava.jar" RockPaperScissors.java```

Code to run:
```LD_LIBRARY_PATH=. java -cp ../LeapJava.jar:. RockPaperScissors```

...or, just set it up in your favourite IDE!

### Possible extension to Rock, Paper, Scissors...
Rock, Paper, Scissors, Lizard, Spock? Why are all the shapes so similar?!?!?! :scream:

## But WAIT! There is more... LeapNetworkRockPaperScissors!
Say what!?! You crazy son of a gun, no way!

Yes way, actually.

With basic 'Rock, Paper, Scissors' working, why can't you just transmit the inputs of two Clients to a Server, and get the results back, all using TCP?

Oh wait, *you can*...

### To use...
Do the same stuff as the other two (but with `RPSClient.java` and `RPSServer.java`), then...
Start the server up (it'll listen on port 1337). After that, start up two Clients, submit your rock, paper, or scissor using your Leap, and wait for the Server to get back to you!

It's set up for `localhost` here, but you can change the client to point at a specific server's IP address.

## LeapTranslate
**NOT YET IMPLEMENTED**

Another cool idea would be to translate basic sign language (maybe start off with the [American Fingerspelled Alphabet](http://www.lifeprint.com/asl101/fingerspelling/fingerspelling.htm), outputting a letter when a hand gesture is recognised.

But again... Why are there so many letters that look so similar :scream:
