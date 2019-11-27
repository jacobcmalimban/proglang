magiCoin :: Bool -> Bool
magiCoin = \x -> True

cnvrt :: Bool -> String
cnvrt = show .

main = do
    putStrLn "Value is: " ++ cnvrt True
