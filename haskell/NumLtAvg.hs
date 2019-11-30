
purifiedNums :: Int -> [String] -> [Int]
purifiedNums 0 _ = []
purifiedNums counter list = 
    [ read (head list) :: Int
        : purifiedNums (counter + (-1)) tail list ]


main = do
    putStrLn "Enter the count and the corresponding integer values:"
    line <- getLine
--  map (\x -> read x :: Int)    
    putStrLn "The list:"
