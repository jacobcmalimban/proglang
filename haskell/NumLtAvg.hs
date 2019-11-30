
purifiedNums :: Int -> [Int] -> [Int]
purifiedNums 0 _ = []
purifiedNums counter list =  
    head list : purifiedNums (counter - 1) (tail list)

strToInt :: [String] -> [Int]
strToInt strLst = map (\x -> read x :: Int) strLst

main = do
    putStrLn "Enter the count and the corresponding integer values:"
    line <- getLine

{-
    putStrLn(
        purifiedNums
        (head (strToInt(words line))
        (tail (strToInt(words line))
    )
-}


--    putStrLn purifiedNums ( head ( map (\x -> read x :: Int) (words line)) ) ( tail ( map (\x -> read x :: Int) (words line)) )

--  ints = words line
--  map (\x -> read x :: Int)    
    putStrLn("The list: " ++ line)
