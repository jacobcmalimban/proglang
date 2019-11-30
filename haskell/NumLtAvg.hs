import Data.List

-- clean output
show' :: Show a => [a] -> String
show' = intercalate " " . map show

-- takes an int (counter) & [int] (list) to produce 
--  a new list of length counter
purifiedNums :: Int -> [Int] -> [Int]
purifiedNums 0 _ = []
purifiedNums counter list =  
    head list : purifiedNums (counter - 1) (tail list)

-- converts string to int list
strToInt :: [String] -> [Int]
strToInt strLst = map (\x -> read x :: Int) strLst

-- convert space-seperated string to string list without spaces
--fmt :: String -> ([String] -> [Int])
fmt line = strToInt(words line)


main = do
    putStrLn "Enter the count and the corresponding integer values: "
    line <- getLine

    -- retrieve first number
    let listlen = fromIntegral (head (fmt line))
    let purified = purifiedNums (head (fmt line)) (tail (fmt line)) 

    -- display valid list
    putStrLn("The list: ")
    putStrLn $ id(show' purified)

    -- calculate list sum and find average
    putStrLn("The average: ")
    let inSum = fromIntegral (sum purified)
    let avg = inSum / listlen
    putStrLn $ show( avg )

    putStrLn("Number of values less than average: ")
    let ltAvg = filter (< avg) (map (fromIntegral) purified)

    putStrLn $ show(length ltAvg)
