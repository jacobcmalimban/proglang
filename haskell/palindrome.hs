
{-

Input: A string of characters

Output: The string, its reverse, and indicating if the string is palindrome.

Sample input and output:

Enter a string: Hi There!

“Hi There!” is not a palindrome

Enter a string: devoved

“devoved” is a palindrome

-}

-- take two strings and test for equality
testPalin :: [Char] -> [Char] -> Bool
testPalin [] []             = True
testPalin (x:xs) (y:ys)     = x == y && testPalin xs ys
testPalin _ _               = False

-- determine output via boolean and concat the word
palinput :: Bool -> String -> String
palinput x y 
    | x         = "\"" ++ y ++ "\"" ++ " is a palindrome\n"
    | otherwise = "\"" ++ y ++ "\"" ++ " is not a palindrome\n"

{-
main = do
    putStrLn "Press q to quit"
    line <- getLine
    unless (line == "q") $ do
      main
-}

main = do
    putStr "Enter a string: "
    npt <- getLine
    
    putStr ( palinput (testPalin npt (reverse npt)) npt ) 
    --                  ^^ Test if npt == its reverse
    --  if true, it is a palindrome
