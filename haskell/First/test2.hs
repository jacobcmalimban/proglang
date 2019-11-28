import System.IO
import Data.List


magiCoin :: Bool -> Bool
magiCoin = \x -> True

cnvrt :: Bool -> String
cnvrt = show .

main = do
    putStrLn "Value is: " ++ cnvrt True

-- int
    maxInt = maxBound :: Int
    putStrLn maxInt

{-
    sumNum = sum [1..1000]
    
    putStrLn sumNum
-}
