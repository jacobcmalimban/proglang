import Data.List
import System.IO

{-
	No /**/ ;(


sumNums = sum [0..999]
maxInt = maxBound :: Int

main = do
    putStrLn "Hello"    

    putStrLn "" ++ sumNums
-}


-- Int
maxInt = maxBound :: Int
minInt = minBound :: Int

-- immutable Var
alway5 :: Int
alway5 = 5

-- math
sumNum = sum[1.999]
prefMod = mod 6 4
infxMod = 6 `mod` 4 -- ~ button
negNum = 6 + (-4) -- note (paren) enclosure
sqrt5 = sqrt(fromIntegral alway5)
tau = 2 * pi
fiveSqr = 5 ** 2

{-
	sin, truncate, round, ceiling, floor
-}


-- Boolean
tnf = True && False
tof = True || False
noT = not(True)

-- lists
priNums = [2, 3, 5, 7]
morPri = priNums ++ [11, 13, 17, 19]

twDLst = [priNums, [11,13,17,19]]
lenPri = length priNums
len2D = length twDLst

revPri = reverse morPri
lstEmpty = null revPri

prim3 = morPri !! 2 -- 3rd element
firstPri = head morPri -- 1st element
lastPri = last morPri -- last element
nvrtLast = init morPri -- everything but last

tak3Pri = take 3 morPri -- first 3 elements
rem3 = drop 3 morPri -- after element 3
