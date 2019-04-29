function [c,cr] = v_frq2cent(frq)
persistent p q
if isempty(p)
    p=1200/log(2);
    q=5700-p*log(440);
end
af=abs(frq);
% c = 1200*sign(frq).*log2(frq/(440*2^((3/12)-5)));
c=sign(frq).*(p*log(af)+q);
cr=af/p;
if ~nargout
    plot(frq,c,'-x');
    xlabel(['Frequency (' v_xticksi 'Hz)']);
    ylabel(['Frequency (' v_yticksi 'Cents)']);
end
end