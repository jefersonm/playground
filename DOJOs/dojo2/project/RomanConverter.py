class RomanConverter():
    
    def __init__(self):
    	self

    def convertSingleNumber(self, numeroRomano):
    	if numeroRomano == "I":
    		return 1
    	elif numeroRomano == "V": 
    		return 5

    def convertComposeNumber(self, nr):
    	resultadoNumerico = 0

    	nr1 = list(nr)[0]
    	nr2 = list(nr)[1]	
    	if nr1 == "I" and nr2 != "I":  
    		return self.convertSingleNumber(nr2) - self.convertSingleNumber(nr1)

    	for x in list(nr):
    		resultadoNumerico = resultadoNumerico + self.convertSingleNumber(x)

    	return resultadoNumerico