# CharacterToWordsMapper

[![Build Status](https://travis-ci.org/must1/CharacterToWordsMapper.svg?branch=master)](https://travis-ci.org/must1/CharacterToWordsMapper)

Application that is mapping words to containing letters. Mapped words are sorted alphabetically, just like letters. 

For example, given sentence: ala ma kota, kot koduje w Javie kota.
- a: ala, javie , kota, ma
- d: koduje
- e: javie , koduje
- i: javie
- j: javie, koduje
- k: koduje, kot, kota
- l: ala
- m: ma
- o: koduje, kot, kota
- t: kot, kota
- u: koduje
- v: javie
- w: w

After every run of application, it stores the sentence and the result.

Application uses:
- Java 9
- JUnit
- Travis CI
- Lombok
