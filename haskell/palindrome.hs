
{-

Input: A string of characters

Output: The string, its reverse, and indicating if the string is palindrome.

Sample input and output:

Enter a string: Hi There!

“Hi There!” is not a palindrome

Enter a string: devoved

“devoved” is a palindrome

-}

testPalin :: [Char] -> [Char] -> Bool
testPalin [] []             = True
testPalin (x:xs) (y:ys)     = x == y && testPalin xs ys
testPalin _ _               = False

palinput :: Bool -> String -> String
palinput x y 
    | x         = "\"" ++ y ++ "\"" ++ " is a palindrome"
    | otherwise = "\"" ++ y ++ "\"" ++ " is not a palindrome"

{-
main = do
    putStrLn "Press q to quit"
    line <- getLine
    unless (line == "q") $ do
      main
-}

main = do
    putStrLn "Enter a string: "
    npt <- getLine
    
    putStrLn ( palinput (testPalin npt (reverse npt)) npt )
