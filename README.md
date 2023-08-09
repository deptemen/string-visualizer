String Visualizer:
-------------------------
Provided two strings,find the maximum occurrence of characters common in both the strings and resulting string 
should contain the string number which has the maximum occurrence and the repeated characters seperated by '/'

example1:
inputs:
s1 = "my&friend&Paul has heavy hats! &"
s2 = "my friend John has many many friends &"
output:
mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
-------------------------------------------------------------------------------------------------------
example2:
inputs:
s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
output:
mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
---------------------------------------------------------------------------------------------------
example3:
inputs:
s1="Are the kids at home? aaaaa fffff"
s2="Yes they are here! aaaaa fffff"
output:
mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"
