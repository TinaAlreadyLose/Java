function m = v_pesq2mos(p)
persistent a b c d
if isempty(a)
    a=0.999;
    b=4.999-a;
    c=-1.4945;
    d=4.6607;
end
if nargout>0
    m=a+b./(1+exp(c*p+d));
else
    if nargin<1 || isempty(p)
        pp=linspace(-0.5,4.5,100);
    else
        pp=p;
    end
    plot(pp,v_pesq2mos(pp));
    xlabel('PESQ (P.862)');
    ylabel('Mean Opimion Score (MOS)');
end
