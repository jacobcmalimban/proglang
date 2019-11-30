import Data.List

show' :: Show a => [a] -> String
show' = intercalate " " . map show

purifiedNums :: Int -> [Int] -> [Int]
purifiedNums 0 _ = []
purifiedNums counter list =  
    head list : purifiedNums (counter - 1) (tail list)

strToInt :: [String] -> [Int]
strToInt strLst = map (\x -> read x :: Int) strLst

--fmt :: String -> ([String] -> [Int])
fmt line = strToInt(words line)


main = do
    putStrLn "Enter the count and the corresponding integer values: "
    line <- getLine

    let listlen = fromIntegral (head (fmt line))
    let purified = purifiedNums (head (fmt line)) (tail (fmt line)) 

    putStrLn("The list: ")
    putStrLn $ id(show' purified)

    putStrLn("The average: ")
    let inSum = fromIntegral (sum purified)
    let avg = inSum / listlen
    putStrLn $ show( avg )

    putStrLn("Number of values less than average: ")
    let ltAvg = filter (< avg) (map (fromIntegral) purified)


    putStrLn $ show(length ltAvg)
--    putStrLn( length ltAvg )


--(fromIntegral (sum purified)) / (length purified) )
-- sum purified  /   
--    length purified )


--    putStrLn $ show ( (sum(map (fromIntegral) purified)) / length purified)

--    putStrLn(     putStrLn $ show ( sum purified / length purified )


{-

    putStrLn("Number of values less than average:")
    putStrLn()

-}
