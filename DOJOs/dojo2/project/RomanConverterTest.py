import unittest
import RomanConverter as r

class RomanConverterTest(unittest.TestCase):

    converter = r.RomanConverter()

    def test_I(self):
        self.assertEqual(self.converter.convertSingleNumber("I"), 1)

    def test_V(self):
    	self.assertEqual(self.converter.convertSingleNumber("V"), 5)   

    def test_VI(self):
    	self.assertEquals(self.converter.convertComposeNumber("VI"), 6)

    def test_IV(self):
    	self.assertEquals(self.converter.convertComposeNumber("IV"), 4)	

    def test_II(self):
    	self.assertEquals(self.converter.convertComposeNumber("II"), 2)

    def test_VII(self):
    	self.assertEquals(self.converter.convertComposeNumber("VII"), 7)	
        
if __name__ == '__main__':
    unittest.main()