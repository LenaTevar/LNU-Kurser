;>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
; I have no clue where the fricking report is for lab 1.
;>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
;   1DT301, Computer Technology I
;   Date: 2018-09-10
;   Author:
;                       Jiahui Le (jl224bn)
;						Helena Tevar (ht222fd)
;
;   Lab number:         1
;   Title:              How to use the PORTs. Digital input /output.
;                       Subroutine call.
;
;   Hardware:           STK600, CPU ATmega2560
;
;   Function:           Lights LED2 on PORTB
;
;   Input ports:        No input used
;
;   Output ports:       PIN2 on PORTB
;
;   Subroutines:        No subroutines used 
;
;   Included files:     m2560def.inc
;
;   Other information:  In order to light a led, you have to set
;						the number of the PIN you want to use as 0
;						For example: LED2 on would be 0b1111_1011
;
;   Changes in program: 
;						2018/09/10
;						Implementation on board succesfully
;
;<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



.include "m2560def.inc"

.def temp = r16       ; .def creates a sort of variable


ldi temp, 0xFF				;Set PORT B as output = 0xFF			
out DDRB, temp				


ldi temp, 0b11111011		;Turn on Led 2 using PORTB
out PORTB, temp

;>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
;   1DT301, Computer Technology I
;   Date: 2018-09-10
;   Author:
;                       Jiahui Le (jl224bn)
;						Helena Tevar (ht222fd)
;
;   Lab number:         2
;   Title:              How to use the PORTs. Digital input /output.
;                       Subroutine call.
;
;   Hardware:           STK600, CPU ATmega2560
;
;   Function:           Light LED in PORTB corresponding its Switch in PORTD
;
;   Input ports:        PORTD
;
;   Output ports:       PORTB
;
;   Subroutines:        No subroutines used 
;
;   Included files:     m2560def.inc
;
;   Other information:  In order to light a led, you have to press
;						a switch. The input from the switch will 
;						activate the corresponding led. 
;
;   Changes in program: 
;						2018/09/10
;						Implementation on board succesfully
;
;<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



.include "m2560def.inc"

.def temp = r16


ldi temp, 0xFF 				;Set PORTB as output (Leds)
out DDRB, temp 	

ldi temp, 0x00 				;Set PORTD as input (Switches)
out DDRD, temp				

loop:						
	in temp, PIND			;Read input from PIND (Switches)
	out PORTB, temp			;Output PIND into PORTB (Leds)
	rjmp loop
;>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
;   1DT301, Computer Technology I
;   Date: 2018-09-10
;   Author:
;                       Jiahui Le (jl224bn)
;						Helena Tevar (ht222fd)
;
;   Lab number:         3
;   Title:              How to use the PORTs. Digital input /output.
;                       Subroutine call.
;
;   Hardware:           STK600, CPU ATmega2560
;
;   Function:           Light led 0 if switch 5 is pressed
;
;   Input ports:        PORTD
;
;   Output ports:       PORTB
;
;   Subroutines:        No subroutines used 
;
;   Included files:     m2560def.inc
;
;   Other information:  If other switch rather than switch 5 is pressed
;						no led should light. 
;
;   Changes in program: 
;						2018/09/10
;						Implementation on board succesfully
;
;<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


.include "m2560def.inc"
.def temp = r16
.def ledOutput = r17


ldi temp, 0xFF 						;Set PORTB as output (leds)
out DDRB, temp 	

ldi temp, 0x00 						;Set PORTD as input (switches)
out DDRD, temp	

ldi temp, 0xFF						;Let all the leds turn off
out PORTB, temp 

ldi ledOutput, 0b1111_1110			;set ledOutput as led0

loop: 
	in temp, PIND					;read switch D and save to the register
	
	cpi  temp, 0b1101_1111			;Compare temp with sw5
	breq equal						;If temp is equal to sw5, branch to equal
rjmp loop

equal: out PORTB, ledOutput			;light led0
;>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
;   1DT301, Computer Technology I
;   Date: 2018-09-10
;   Author:
;                       Jiahui Le (jl224bn)
;						Helena Tevar (ht222fd)
;
;   Lab number:         5
;   Title:              How to use the PORTs. Digital input /output.
;                       Subroutine call.
;
;   Hardware:           STK600, CPU ATmega2560
;
;   Function:           Ring Counter
;
;   Input ports:        PORTD
;
;   Output ports:       PORTB
;
;   Subroutines:        delay 500ms
;
;   Included files:     m2560def.inc
;
;   Other information:   Function, the 8 LEDs 
;						 0000 000X, 0000 00X0, 0000 0X00, 0000 X000, 
;						 000X 0000, 00X0 0000, 0X00 0000, X000 0000 
;
;   Changes in program: 
;						2018/09/10
;						Implementation on board succesfully
;
;<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


.include "m2560def.inc"
.def temp = r16

;Initialize SP, STack Pointer
ldi r20, HIGH(RAMEND)				;R20 = high part of RAMEND address
out SPH, R20						;SPH = high part of RAMEND address
ldi R20, low(RAMEND)				;R20 = low part of RAMEND address
out SPL, R20						;SPL = low part of RAMEND address





ldi temp, 0xFF 						;Set PORTB as output
out DDRB, temp 	

loop:
	out PORTB, temp					;Show all leds off in PORTB
	rol temp						;Logical shift to the left -> temp +1									
 	rcall delay						;Call delay method

rjmp loop							;Repeat loop




; Generated by delay loop calculator
; at http://www.bretmulvey.com/avrdelay.html
;
; Delay 500 000 cycles
; 500ms at 1 MHz

delay:
    push r18
	push r19
	push r20
	
    ldi  r18, 3
    ldi  r19, 138
    ldi  r20, 86
L1: dec  r20
    brne L1
    dec  r19
    brne L1
    dec  r18
    brne L1
    rjmp PC+1
	
	pop r20
	pop r19
	pop r18
    ret
    
    ;>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
;   1DT301, Computer Technology I
;   Date: 2018-09-10
;   Author:
;                       Jiahui Le (jl224bn)
;						Helena Tevar (ht222fd)
;
;   Lab number:         6
;   Title:              How to use the PORTs. Digital input /output.
;                       Subroutine call.
;
;   Hardware:           STK600, CPU ATmega2560
;
;   Function:           Johnson Counter
;
;   Input ports:        PORTD
;
;   Output ports:       PORTB
;
;   Subroutines:        delay 500ms
;
;   Included files:     m2560def.inc
;
;   Other information:   Function, the 8 LEDs:
;						 0000 000X, 0000 00XX, 0000 0XXX, 0000 XXXX, 000X XXXX, 00XX XXXX, 0XXX XXXX,
;						 XXXX XXXX, 0XXX XXXX, 00XX XXXX, 000X XXXX, 0000 XXXX, 0000 0XXX, 0000
;						 00XX, 0000 000X, 0000 0000
;
;   Changes in program: 
;						2018/09/10
;						Analysis and logic
;						
;						2018/09/11
;						Test on board
;
;<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


.include "m2560def.inc"
.def data = r16

;Initialize SP, STack Pointer
ldi r20, HIGH(RAMEND)	;R20 = high part of RAMEND address
out SPH, R20			;SPH = high part of RAMEND address
ldi R20, low(RAMEND)	;R20 = low part of RAMEND address
out SPL, R20			;SPL = low part of RAMEND address


ldi data, 0xFF
out DDRB, data

; This code follows the pattern explained in "Other Information"


loopTurnOn:				;Loop that turns the lights on from 0xFF to 0x00. 
						;temp starts at 0xff
	lsl data			;data moves one to the left (example: From 0xFF to 0xFE)
	
	out PORTB, data		;turn on led number data from PORTB
	rcall delay			;Call delay
	cpi data, 0x00		;Compare data to "all lights on"
	breq fixLeds		;If data is 0x00, go to fixleds

	rjmp loopTurnOn		;if data is not 0x00, loop again


fixLeds:				;loopTurnOff cannot work if data is 0x00, so 
						;we have to fix that. We will give a kick start to data
						;and move to the loopTurnOff

	ldi data, 0x80		;Load data with the led 0b1000_0000
	out PORTB, data
	rcall delay
	rjmp loopTurnOff	;kick start to loopTurnOff

loopTurnOff:			;Loop that turns the lights off from 0x80 to 0xFF
	asr data			;arithmetic shift right (Ex: from 0x80 -> 0xC0)
	
	out PORTB, data		;turn on leds 
	rcall delay
	cpi data, 0xFF		;Compare data to "all lights off"
	breq loopTurnOn		;If all the leds are off, go to loopTurnOn

	rjmp loopTurnOff	;If data is not 0xFF, loop again


; Generated by delay loop calculator
; at http://www.bretmulvey.com/avrdelay.html
;
; Delay 500 000 cycles
; 500ms at 1 MHz
delay:
    push r18
	push r19
	push r20
	
    ldi  r18, 3
    ldi  r19, 138
    ldi  r20, 86
L1: dec  r20
    brne L1
    dec  r19
    brne L1
    dec  r18
    brne L1
    rjmp PC+1
	
	pop r20
	pop r19
	pop r18
    ret
;>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
;   1DT301, Computer Technology I
;   Date: 2018-09-10
;   Author:
;                       Jiahui Le (jl224bn)
;						Helena Tevar (ht222fd)
;
;   Lab number:         6
;   Title:              How to use the PORTs. Digital input /output.
;                       Subroutine call.
;
;   Hardware:           STK600, CPU ATmega2560
;
;   Function:           Johnson Counter
;
;   Input ports:        PORTD
;
;   Output ports:       PORTB
;
;   Subroutines:        delay 500ms
;
;   Included files:     m2560def.inc
;
;   Other information:   Function, the 8 LEDs:
;						 0000 000X, 0000 00XX, 0000 0XXX, 0000 XXXX, 000X XXXX, 00XX XXXX, 0XXX XXXX,
;						 XXXX XXXX, 0XXX XXXX, 00XX XXXX, 000X XXXX, 0000 XXXX, 0000 0XXX, 0000
;						 00XX, 0000 000X, 0000 0000
;
;   Changes in program: 
;						2018/09/10
;						Analysis and logic
;						
;						2018/09/11
;						Test on board
;
;<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


.include "m2560def.inc"
.def data = r16

;Initialize SP, STack Pointer
ldi r20, HIGH(RAMEND)	;R20 = high part of RAMEND address
out SPH, R20			;SPH = high part of RAMEND address
ldi R20, low(RAMEND)	;R20 = low part of RAMEND address
out SPL, R20			;SPL = low part of RAMEND address


ldi data, 0xFF
out DDRB, data

; This code follows the pattern explained in "Other Information"


loopTurnOn:				;Loop that turns the lights on from 0xFF to 0x00. 
						;temp starts at 0xff
	lsl data			;data moves one to the left (example: From 0xFF to 0xFE)
	
	out PORTB, data		;turn on led number data from PORTB
	rcall delay			;Call delay
	cpi data, 0x00		;Compare data to "all lights on"
	breq fixLeds		;If data is 0x00, go to fixleds

	rjmp loopTurnOn		;if data is not 0x00, loop again


fixLeds:				;loopTurnOff cannot work if data is 0x00, so 
						;we have to fix that. We will give a kick start to data
						;and move to the loopTurnOff

	ldi data, 0x80		;Load data with the led 0b1000_0000
	out PORTB, data
	rcall delay
	rjmp loopTurnOff	;kick start to loopTurnOff

loopTurnOff:			;Loop that turns the lights off from 0x80 to 0xFF
	asr data			;arithmetic shift right (Ex: from 0x80 -> 0xC0)
	
	out PORTB, data		;turn on leds 
	rcall delay
	cpi data, 0xFF		;Compare data to "all lights off"
	breq loopTurnOn		;If all the leds are off, go to loopTurnOn

	rjmp loopTurnOff	;If data is not 0xFF, loop again


; Generated by delay loop calculator
; at http://www.bretmulvey.com/avrdelay.html
;
; Delay 500 000 cycles
; 500ms at 1 MHz
delay:
    push r18
	push r19
	push r20
	
    ldi  r18, 3
    ldi  r19, 138
    ldi  r20, 86
L1: dec  r20
    brne L1
    dec  r19
    brne L1
    dec  r18
    brne L1
    rjmp PC+1
	
	pop r20
	pop r19
	pop r18
    ret
